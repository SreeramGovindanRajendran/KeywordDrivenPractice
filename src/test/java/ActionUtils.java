import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ActionUtils {

    Actions actions = new Actions();
    static Method[] methods;

    ActionUtils() {
        methods=actions.getClass().getMethods();
    }

    public void actionInvoker() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for (Method methodName : methods) {
            if (ExcelUtils.actionValue.trim().equalsIgnoreCase(methodName.getName())) {
                actions.getClass().getMethod(methodName.getName()).invoke(actions);
                break;
            }
        }
    }



}
