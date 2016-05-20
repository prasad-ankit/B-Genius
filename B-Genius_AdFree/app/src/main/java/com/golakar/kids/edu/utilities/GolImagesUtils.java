/**Project Under : Golakar Kids Apps
 * You can not modify & redistribute without permission from the author
 * Project published on Golakar Technology platform April, 2014
 * Release Template for the buyer august 2015
 */
package com.golakar.kids.edu.utilities;

import android.graphics.drawable.Drawable;

public class GolImagesUtils {
	
    private String golName;
    private Drawable golImages;

    public GolImagesUtils(String golName, Drawable golImages){
    	this.golName = golName;
    	this.golImages = golImages;
    }
    
    public String getGolName() {
        return golName;
    }
    public void setGolName(String golName) {
        this.golName = golName;
    }
    public Drawable getGolImages() {
        return golImages;
    }
    public void setGolImages(Drawable golImages) {
        this.golImages = golImages;
    }
    
    @Override
    public boolean equals(Object obj){
    	
    	if(obj instanceof GolImagesUtils){
    		return this.golName.equals(((GolImagesUtils) obj).getGolName());
    	} else {
    		return false;
    	}
    	
    }
}
