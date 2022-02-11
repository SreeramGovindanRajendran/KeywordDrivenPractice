import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ActionUtils {

    static Method[] methods;
    Actions actions = new Actions();

    ActionUtils() {
        methods = actions.getClass().getMethods();
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
