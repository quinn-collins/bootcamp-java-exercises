package com.techelevator;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class TelevisionTest {
	private Television myTv;
	
	@Before
	public void setup() {
		myTv = new Television();
	}
	
	@Test
	public void television_initializes_correctly() {
		// Assert
		Assert.assertEquals(3, myTv.getSelectedChannel());
		Assert.assertEquals(2, myTv.getCurrentVolume());
		Assert.assertFalse("TV should be off", myTv.isOn());
	}
	
	@Test
	public void can_turn_on_tv() {
		// Act
		myTv.TurnOn();
		// Assert
		Assert.assertTrue("TV should be on", myTv.isOn());
	}
	
	@Test
	public void can_turn_off_tv() {
		// Arrange
		myTv.TurnOn();
		// Act
		myTv.TurnOff();
		// Assert
		Assert.assertFalse("TV should be off", myTv.isOn());
	}
	
	@Test
	public void tv_must_be_on_to_change_channels() {
		// Act
		myTv.ChangeChannel(6);
		// Assert
		Assert.assertEquals(3, myTv.getSelectedChannel());
	}
	
	@Test
	public void can_change_channel() {
		// Arrange
		myTv.TurnOn();
		// Act
		myTv.ChangeChannel(6);
		// Assert
		Assert.assertEquals(6, myTv.getSelectedChannel());
	}
	
	@Test
	public void can_not_change_channel_lower_than_3() {
		// Arrange
		myTv.TurnOn();
		// Act
		myTv.ChangeChannel(2);
		// Assert
		Assert.assertEquals(3, myTv.getSelectedChannel());
	}
	
	@Test
	public void can_not_change_channel_greater_than_18() {
		// Arrange
		myTv.TurnOn();
		// Act
		myTv.ChangeChannel(19);
		//Assert
		Assert.assertEquals(3, myTv.getSelectedChannel());
	}
	
	@Test
	public void channel_18_is_a_valid_channel() {
		// Arrange
		myTv.TurnOn();
		// Act
		myTv.ChangeChannel(18);
		// Assert
		Assert.assertEquals(18, myTv.getSelectedChannel());
	}
	
	@Test
	public void channel_3_is_a_valid_channel() {
		// Arrange
		myTv.TurnOn();
		myTv.ChangeChannel(6);
		// Act
		myTv.ChangeChannel(3);
		// Assert
		Assert.assertEquals(3, myTv.getSelectedChannel());
	}
	
	@Test
	public void can_lower_the_volume() {
		// Arrange
		myTv.TurnOn();
		// Act
		myTv.lowerVolume();
		// Assert
		Assert.assertEquals(1, myTv.getCurrentVolume());
	}
	
	@Test
	public void cannot_lower_volume_with_tv_off() {
		// Act
		myTv.lowerVolume();
		// Assert
		Assert.assertEquals(2, myTv.getCurrentVolume());
	}
	
	@Test
	public void cannot_lower_volume_past_0() {
		// Arrange
		myTv.TurnOn();
		myTv.lowerVolume();
		myTv.lowerVolume();
		// Act
		myTv.lowerVolume();
		// Assert
		Assert.assertEquals(0, myTv.getCurrentVolume());
	}
	
	@Test
	public void can_lower_volume_to_0() {
		// Arrange
		myTv.TurnOn();
		myTv.lowerVolume();
		// Act
		myTv.lowerVolume();
		// Assert
		Assert.assertEquals(0, myTv.getCurrentVolume());
	}
	
	@Test
	public void can_raise_volume() {
		myTv.TurnOn();
		// Act
		myTv.raiseVolume();
		// Assert
		Assert.assertEquals(3, myTv.getCurrentVolume());
	}
	
	@Test
	public void cannot_raise_volume_with_tv_off() {
		// Act
		myTv.raiseVolume();
		// Assert
		Assert.assertEquals(2, myTv.getCurrentVolume());
	}
	
	@Test
	public void can_raise_to_volume_ten(){
		// Assert
		myTv.TurnOn();
		myTv.raiseVolume();
		myTv.raiseVolume();
		myTv.raiseVolume();
		myTv.raiseVolume();
		myTv.raiseVolume();
		myTv.raiseVolume();
		myTv.raiseVolume();
		// Act
		myTv.raiseVolume();
		// Assert
		Assert.assertEquals(10, myTv.getCurrentVolume());

	}
	
	@Test
	public void cant_raise_volume_past_10() {
		myTv.TurnOn();
		myTv.raiseVolume();
		myTv.raiseVolume();
		myTv.raiseVolume();
		myTv.raiseVolume();
		myTv.raiseVolume();
		myTv.raiseVolume();
		myTv.raiseVolume();
		myTv.raiseVolume();
		myTv.raiseVolume();
		myTv.raiseVolume();
		myTv.raiseVolume();
		Assert.assertEquals(10, myTv.getCurrentVolume());
	}
}
