/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author lab
 */
public class Table {
    private Resource[] resources;
    
    public Resource[] removeResources(){
    	Resource[] resources = this.resources;
    	this.resources = null;
    	return resources;
    }
    
    public boolean validResourceForSmoke(Resource resource){
    	if (isEmpty())
    		return false;
    	for (Resource aux:resources)
    		if (aux.getType() == resource.getType())
    			return false;
    	return true;
    }
    
    public boolean isEmpty(){
    	return resources == null;    		
    }
    
    @Override
    public String toString(){
    	String string = "Table resources:";
    	if (isEmpty())
    		string += "\n\tThere's no resources in table!";
    	else
    		for(Resource resource:resources)
    			string += "\n\t"+resource.getType();
		return string;    	
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
       
}
