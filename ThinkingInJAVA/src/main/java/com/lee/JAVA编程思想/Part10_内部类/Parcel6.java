package com.lee.JAVA编程思想.Part10_内部类;

public class Parcel6 {
	private void internalTracking(boolean b) {
		if (b) {
			class TrackingSlip {
				private String id;

				TrackingSlip(String id) {
					this.id = id;
				}

				String getSlip() {
					return id;
				}
			}
			TrackingSlip slip = new TrackingSlip("slip");
			String s = slip.getSlip();
		}
	}

	public void track() {
		internalTracking(true);
	}

	public static void main(String[] args) {
		Parcel6 p = new Parcel6();
		p.track();
	}
}

