package programmers;

import java.util.*;

class RoomBooking {
	public int solution(String[][] book_time) {
		Queue<Booking> bookingQ = new PriorityQueue<>();
		Queue<Room> roomQ = new PriorityQueue<>();
		roomQ.offer(new Room(0));

		for (String[] book : book_time) {
			bookingQ.offer(new Booking(book[0], book[1]));
		}

		while(!bookingQ.isEmpty()) {
			Booking booking = bookingQ.poll();
			Room room = roomQ.peek();
			if (booking.start < room.nextBookingTime) {
				roomQ.offer(new Room(booking.end + 10));
			} else {
				room = roomQ.poll();
				room.nextBookingTime = booking.end + 10;
				roomQ.offer(room);
			}
		}

		return roomQ.size();
	}

	static class Room implements Comparable<Room> {
		int nextBookingTime;

		public Room(int nextBookingTime) {
			this.nextBookingTime = nextBookingTime;
		}

		@Override
		public int compareTo(Room r) {
			return this.nextBookingTime - r.nextBookingTime;
		}
	}

	static class Booking implements Comparable<Booking> {
		int start;
		int end;

		public Booking (String startTime, String endTime) {
			String[] startTimes = startTime.split(":");
			String[] endTimes = endTime.split(":");

			this.start = Integer.parseInt(startTimes[0]) * 60 + Integer.parseInt(startTimes[1]);
			this.end = Integer.parseInt(endTimes[0]) * 60 + Integer.parseInt(endTimes[1]);
		}

		@Override
		public int compareTo(Booking o) {
			if (o.start == this.start) {
				return this.end - o.end;
			}

			return this.start - o.start;
		}
	}
}