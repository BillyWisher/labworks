package by.gsu.lab4;

public class ExplorerException extends Exception {
	 private static final long serialVersionUID = 1L;
	    private int number;
	    private String line;

	    public ExplorerException(final String message, final int number, final String line) {
	        super(message);
	        this.number = number;
	        this.line = line;
	    }
	    public ExplorerException(final String message, final int number) {
	        super(message);
	        this.number = number;
	    }  
	    
	    public ExplorerException(final String message,final String line) {
	        super(message);
	        this.line = line;
	    }
	    
	    public int getNumber() {
	        return this.number;
	    }

	    public String getLine(){
	    	return this.line;
	}

}
