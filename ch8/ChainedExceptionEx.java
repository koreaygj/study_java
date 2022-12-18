package ch8;

public class ChainedExceptionEx {
    public static void main(String args[]){
        try{
            install();
        }
        catch(InstallException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    static void install() throws InstallException{
        try{
            startInstall();
            copyFile();
        }
        catch(SpaceException e){
            InstallException ie = new InstallException("설치 중 예외발생");
            ie.initCause(e);
            throw ie;
        }
        catch(MemoryException e){
            InstallException ie = new InstallException("설치 중 예외발생");
            ie.initCause(e);
            throw ie;
        }
        finally{
            deleteTempFiles();
        }
    }
    static void startInstall() throws SpaceException, MemoryException{
        if(!enoughSpace()){
            throw new SpaceException("메모리가 부족합니다.");
        }
        if(!enoughMemory()){
            throw new MemoryException("메모리가 부족합니다.");
        }
    }
    static void copyFile(){
        /*copy file */
    }
    static void deleteTempFiles(){
        /*delete temp files */
    }
    static boolean enoughSpace(){
        /*공간을 확인하는 코드. */
        return false;
    }
    static boolean enoughMemory(){
        /*메모리를 확인하는 코드 */
        return true;
    }
}
    class InstallException extends Exception{
        InstallException(String msg){
            super(msg);
        }
    }
    class SpaceException extends Exception{
        SpaceException(String msg){
            super(msg);
        }
    }
    class MemoryException extends Exception{
        MemoryException(String msg){
            super(msg);
        }
    }
    
