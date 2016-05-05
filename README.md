# g-rule
轻量级规则引擎

## Demo

    public class App {

        public static void main(String[] args) {
            Context context = new SimpleContext();

            Action action = new TestAction();
            Condition condition = new TestCondition();
            condition.registerFalseAction(action);

            RuleEngine.getInstance().setEntry(condition).run(context);
        }

        public static class TestCondition extends AbstractCondition {
            public void check(Context context) {
                System.out.println("condition run!");
                context.set("test", "ok");
            }

            public boolean getResult() {
                return false;
            }
        }

        public static class TestAction extends AbstractAction {
            public void run(Context context) {
                System.out.println("action run!");
                System.out.println(context.get("test"));
            }
        }

    }