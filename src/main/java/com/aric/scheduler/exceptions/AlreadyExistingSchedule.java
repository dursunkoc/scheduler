/**
 * 
 */
package com.aric.scheduler.exceptions;

/**
 * @author dursunkoc
 *
 */
public class AlreadyExistingSchedule extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5736421647724271271L;

	public AlreadyExistingSchedule(String message) {
		super(message);
	}
	
}
