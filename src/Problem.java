/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.concurrent.Semaphore;

/**
 *
 * @author lab
 */
public class Problem {
	private Resource[] defaultResources;
    private Semaphore semaphore;
    private Smoker[] smokers;
    private Agent agent;
    private Table table;
    //threads
    private Thread[] smokersThreads;
    private Thread agentThread;
    
    public Problem(){
        semaphore = new Semaphore(1, true);
        this.smokers = new Smoker[3];   
        this.table = new Table();
        defaultResources = new Resource[3];
        this.agent = new Agent(defaultResources, semaphore, table);          
        setValues();
        createThreads();
    }
    
    private void setValues(){    	
		defaultResources[0] = new Resource("Tabaco");
    	defaultResources[1] = new Resource("Papel");
    	defaultResources[2] = new Resource("Fósforo");
    	for (int i = 0; i < smokers.length; i++) 
    		smokers[i] = new Smoker(defaultResources[i%defaultResources.length], semaphore, table, i);		    	
    }
    
    private void createThreads(){
    	smokersThreads = new Thread[smokers.length];
        for (int i = 0; i < smokersThreads.length; i++) 
        	smokersThreads[i] = new Thread(smokers[i]);	
        agentThread = new Thread(agent);        
    }
    
    public void simulate() throws InterruptedException{    	
    	agentThread.start();    					
    	for (int i = 0; i < smokersThreads.length; i++) 
			smokersThreads[i].start();			
    }
}
