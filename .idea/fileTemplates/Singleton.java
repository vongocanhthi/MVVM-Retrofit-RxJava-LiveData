public class ${NAME} {

    private static ${NAME} instance = null;

    private ${NAME}(){}

    public static ${NAME} getInstance(){
        if(instance == null){
            instance = new ${NAME}();
        }

        return instance;
    }
}