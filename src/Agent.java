/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Random;
import java.util.concurrent.Semaphore;
/**
 *
 * @author lab
 */
public class Agent implements Runnable{
    private Resource[] resources;
    private Semaphore semaphore;
    private Table table;
    private int currentResource;
	public Agent(Resource[] resources, Semaphore semaphore, Table table) {
		super();
		this.resources = resources;
		this.semaphore = semaphore;
		this.table = table;
	}
	public synchronized void produce() throws InterruptedException{
		while(true){
			semaphore.acquire();
			if (table.isEmpty()){				
		        Resource[] resources = new Resource[2];		        
		        resources[0] = this.resources[currentResource%this.resources.length];
		        resources[1] = this.resources[(++currentResource)%this.resources.length];
		        /*int n = new Random().nextInt(this.resources.length);
		        resources[0] = this.resources[n];
		        resources[1] = this.resources[(n+1)%this.resources.length];*/
		        table.setResources(resources);
		        System.out.println(table.toString());
		        Thread.sleep(1000);
			}		
			semaphore.release();
		}
    }		 

    @Override
    public void run() {    	        	
            try {
				produce();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}                   
    }

    /**
     * @return the resources
     */
    public Resource[] getResources() {
        return resources;
    }

    /**
     * @param resources the resources to set
     */
    public void setResources(Resource[] resources) {
        this.resources = resources;
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
     * @return the currentResource
     */
    public int getCurrentResource() {
        return currentResource;
    }

    /**
     * @param currentResource the currentResource to set
     */
    public void setCurrentResource(int currentResource) {
        this.currentResource = currentResource;
    }        
}
