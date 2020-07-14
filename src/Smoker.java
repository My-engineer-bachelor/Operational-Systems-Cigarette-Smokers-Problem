/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.concurrent.Semaphore;

/**
 *
 * @author lab
 */
public class Smoker implements Runnable{
    private Resource resource;
    private Resource[] newResources;
    private Semaphore semaphore;
    private Table table;
    private int qtt;
    private int id;
    
    public Smoker(Resource resource, Semaphore semaphore, Table table, int id){
        this.resource = resource;
        this.semaphore = semaphore;
        this.table = table;
        this.id = id;
    }
    
    public synchronized void smoke() throws InterruptedException{    	
    	while (true){
    		semaphore.acquire();
	        if (table.validResourceForSmoke(resource))
	        	newResources = getTable().removeResources();
	        System.out.println(toString());
            newResources = null;
            Thread.sleep(1000);            
            semaphore.release();
    	}    	
    }
    
     @Override
    public String toString(){
    	String string = "Smoke "+(id+1)+"\n\tResource: "+resource.getType();
    	if (newResources == null)
    		string += "\n\t\tI will not smoke, haven't the suficient resources!";
    	else{
    		string += "\n\t\tI have ";
    		for(Resource resource:newResources)
    			string += resource.getType()+", ";
    		string += "\n\t\tYeeeaahhh! I will smoke!";
    	}
		return string;    	
    }

     @Override
    public void run() {
    	 try {
			smoke();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /**
     * @return the resource
     */
    public Resource getResource() {
        return resource;
    }

    /**
     * @param resource the resource to set
     */
    public void setResource(Resource resource) {
        this.resource = resource;
    }

    /**
     * @return the newResources
     */
    public Resource[] getNewResources() {
        return newResources;
    }

    /**
     * @param newResources the newResources to set
     */
    public void setNewResources(Resource[] newResources) {
        this.newResources = newResources;
    }

    /**
     * @return the semaphore
     */
    public Semaphore getSemaphore() {
        return semaphore;
    }

    /**
     * @param semaphore the semaphore to set
     */
    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    /**
     * @return the table
     */
    public Table getTable() {
        return table;
    }

    /**
     * @param table the table to set
     */
    public void setTable(Table table) {
        this.table = table;
    }

    /**
     * @return the qtt
     */
    public int getQtt() {
        return qtt;
    }

    /**
     * @param qtt the qtt to set
     */
    public void setQtt(int qtt) {
        this.qtt = qtt;
    }     
  
}
