package enterprice.module1;

import java.util.*;

/**
 * Created by corner on 16.03.2016.
 */
public class Module1 {

    private enum OperationsType {
        ADD,
        GET,
        REMOVE,
        CONTAINS,
        POPULATE,
        ITERATOR_ADD,
        ITERATOR_REMOVE
    }

    private enum CollectionType {
        ARRAYLIST,
        LINKEDLIST,
        HASHSET,
        TREESET
    }

    private static final int timesForTries = 100;

    private static Long getTimeOfOperation(CollectionType collectionType, int amount, OperationsType operationType) {

        Long result = null;
        switch (collectionType) {
            case ARRAYLIST:
                result = performOpertaionForList(operationType, amount, new ArrayList<Integer>());
                break;
            case LINKEDLIST:
                result = performOpertaionForList(operationType, amount, new LinkedList<Integer>());
                break;
            case HASHSET:
                result = performOpertaionForSet(operationType, amount, new HashSet<Integer>());
                break;
            case TREESET:
                result = performOpertaionForSet(operationType, amount, new TreeSet<Integer>());
                break;
        }
        return result;
    }

    private static Long collectionAdd(int amount, Collection array) {
        Long timeSpent = System.currentTimeMillis();
        for (int ops = 0; ops < timesForTries; ops++) {
            for (int i = 0; i < amount; i++) {
                array.add(i);
            }
        }
        return System.currentTimeMillis() - timeSpent;
    }

    private static Long collectionPopulate(int amount, Collection array) {
        Long timeSpent = System.currentTimeMillis();
        for (int ops = 0; ops < timesForTries; ops++) {
            Collections.nCopies(365, array);
            array.clear();
        }
        return System.currentTimeMillis() - timeSpent;
    }

    private static Long collectionRemove(int amount, Collection array) {
        Long timeSpent = Long.valueOf(0);
        for (int ops = 0; ops < timesForTries; ops++) {
            for (int i = 0; i < amount; i++) {
                array.add(i);
            }
            Long timeSpentStep = System.currentTimeMillis();
            for (int i = 0; i < amount; i++) {
                array.remove(0);
            }
            timeSpent += (System.currentTimeMillis() - timeSpentStep);
        }
        return timeSpent;
    }

    private static Long collectionContains(int amount, Collection array) {
        Long timeSpent = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            array.add(i);
        }
        timeSpent = System.currentTimeMillis();
        for (int ops = 0; ops < timesForTries; ops++) {
            for (int i = 0; i < amount; i++) {
                array.contains(i);
            }
        }
        return System.currentTimeMillis() - timeSpent;
    }

    private static Long performOpertaionForSet(OperationsType operationType, int amount, Set<Integer> arraySet) {

        Long timeSpent = Long.valueOf(-1);
        switch (operationType) {
            case ADD:
                timeSpent = collectionAdd(amount, arraySet);
                break;
            case POPULATE:
                timeSpent = collectionPopulate(amount, arraySet);
                break;
            case REMOVE:
                timeSpent = collectionRemove(amount, arraySet);
                break;
            case CONTAINS:
                timeSpent = collectionContains(amount, arraySet);
                break;
        }

        return timeSpent;
    }

    private static Long performOpertaionForList(OperationsType operationType, int amount, List<Integer> arrayList) {

        Long timeSpent = Long.valueOf(-1);
        switch (operationType) {
            case ADD:
                timeSpent = collectionAdd(amount, arrayList);
                break;
            case POPULATE:
                timeSpent = collectionPopulate(amount, arrayList);
                break;
            case REMOVE:
                timeSpent = collectionRemove(amount, arrayList);
                break;
            case CONTAINS:
                timeSpent = collectionContains(amount, arrayList);
                break;
            case GET:
                for (int i = 0; i < amount; i++) {
                    arrayList.add(i);
                }
                timeSpent = System.currentTimeMillis();
                for (int ops = 0; ops < timesForTries; ops++) {
                    for (int i = 0; i < amount; i++) {
                        arrayList.get(i);
                    }
                }
                timeSpent = System.currentTimeMillis() - timeSpent;
                break;
            case ITERATOR_ADD:
                timeSpent = System.currentTimeMillis();
                for (int ops = 0; ops < timesForTries; ops++) {
                    ListIterator iterator = arrayList.listIterator();
                    for (int i = 0; i < amount; i++) {
                        iterator.add(i);
                    }
                }
                timeSpent = System.currentTimeMillis() - timeSpent;
                break;
            case ITERATOR_REMOVE:
                timeSpent = Long.valueOf(0);
                for (int ops = 0; ops < timesForTries; ops++) {
                    for (int i = 0; i < amount; i++) {
                        arrayList.add(i);
                    }
                    Long timeSpentStep = System.currentTimeMillis();
                    ListIterator iterator = arrayList.listIterator();
                    while (iterator.hasNext()) {
                        iterator.next();
                        iterator.remove();
                    }
                    timeSpent += System.currentTimeMillis() - timeSpentStep;
                }
                break;
        }

        return timeSpent;
    }

    private static Map<OperationsType, Long> performOpertaions(CollectionType collectionType, int amount) {
        Map<OperationsType, Long> result = new HashMap<>();

        result.put(OperationsType.POPULATE, getTimeOfOperation(collectionType, amount, OperationsType.POPULATE));
        result.put(OperationsType.REMOVE, getTimeOfOperation(collectionType, amount, OperationsType.REMOVE));
        result.put(OperationsType.ADD, getTimeOfOperation(collectionType, amount, OperationsType.ADD));
        result.put(OperationsType.GET, getTimeOfOperation(collectionType, amount, OperationsType.GET));
        result.put(OperationsType.CONTAINS, getTimeOfOperation(collectionType, amount, OperationsType.CONTAINS));
        result.put(OperationsType.ITERATOR_ADD, getTimeOfOperation(collectionType, amount, OperationsType.ITERATOR_ADD));
        result.put(OperationsType.ITERATOR_REMOVE, getTimeOfOperation(collectionType, amount, OperationsType.ITERATOR_REMOVE));

        return result;
    }

    public static void main(String[] args) {

        Map<CollectionType, Map<OperationsType, Long>> collection = new HashMap<>();

        for (CollectionType collectionType : CollectionType.values()) {
            collection.put(collectionType, performOpertaions(collectionType, 1000000));
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<CollectionType, Map<OperationsType, Long>> entry : collection.entrySet()) {
            System.out.println(entry.getKey());
            for (Map.Entry<OperationsType, Long> entry1 : entry.getValue().entrySet()) {
                System.out.format("%10s - %s ", entry1.getKey().toString(), (entry1.getValue() == null ? ' ' : entry1.getValue().toString()));
            }
            System.out.println();
        }

    }
}
