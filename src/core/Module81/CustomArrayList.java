package core.module81;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by vladi_000 on 1/19/2016.
 */
public class CustomArrayList<T extends Comparable> extends ArrayList {

    final Class<T> classOfGeneric;
    final String formatOut = "%30s";
    int lengthOfRow = 0;
    final int asc = 1;
    final int desc = 11;

    final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public CustomArrayList(Class<T> classOfGeneric) {
        this.classOfGeneric = classOfGeneric;
    }

    protected String separateRow() {
        return "\n" + new String(new char[lengthOfRow]).replace("\0", "-") + "\n";
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        Field[] fields = classOfGeneric.getDeclaredFields();

        result.append(" | ");
        //Print header
        for (Field field : fields) {
            result.append(String.format(formatOut, field.getName()));
            result.append(" | ");
        }
        lengthOfRow = result.length();
        result.append(separateRow());

        for (Object row : this) {
            result.append(" | ");
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    if (field.get((T) row) instanceof Calendar) {
                        result.append(String.format(formatOut, sdf.format(((Calendar) field.get((T) row)).getTime())));
                    } else {
                        result.append(String.format(formatOut, field.get((T) row).toString()));
                    }
                    result.append(" | ");
                } catch (IllegalAccessException ex) {
                    System.out.println(ex);
                }
            }
            result.append(separateRow());
        }
        return result.toString();
    }

    public void sort(int sortOrder) {
        for (int i = 0; i < this.size() - 1; i++) {
            for (int j = i; j < this.size(); j++) {
                if (((sortOrder == asc) && (((T) this.get(i)).compareTo((T) this.get(j)) > 0))
                        || ((sortOrder == desc) && (((T) this.get(i)).compareTo((T) this.get(j)) < 0))) {
                    T tmp = (T) this.get(i);
                    this.set(i, this.get(j));
                    this.set(j, tmp);
                }
            }
        }
    }

    public void sort() {
        sort(asc);
    }


}