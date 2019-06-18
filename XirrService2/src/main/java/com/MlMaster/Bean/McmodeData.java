package com.MlMaster.Bean;
                
public class McmodeData
{
    private String mode;

    private String mccode;

    public String getMode ()
    {
        return mode;
    }

    public void setMode (String mode)
    {
        this.mode = mode;
    }

    public String getMccode ()
    {
        return mccode;
    }

    public void setMccode (String mccode)
    {
        this.mccode = mccode;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [mode = "+mode+", mccode = "+mccode+"]";
    }
}
			
			