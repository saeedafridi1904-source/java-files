import java.util.*;

class UndergroundSystem {
    // Class to track active check-ins
    private static class CheckInInfo {
        String stationName;
        int time;

        CheckInInfo(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    // Class to store completed trips
    private static class Trip {
        String startStation;
        String endStation;
        int duration;

        Trip(String startStation, String endStation, int duration) {
            this.startStation = startStation;
            this.endStation = endStation;
            this.duration = duration;
        }
    }

    private Map<Integer, CheckInInfo> checkIns;
    private List<Trip> completedTrips;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        completedTrips = new ArrayList<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInInfo(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInInfo info = checkIns.remove(id);
        int duration = t - info.time;
        completedTrips.add(new Trip(info.stationName, stationName, duration));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        double totalTime = 0;
        int count = 0;

        // Linear scan over all recorded trips every time average is requested
        for (Trip trip : completedTrips) {
            if (trip.startStation.equals(startStation) && trip.endStation.equals(endStation)) {
                totalTime += trip.duration;
                count++;
            }
        }

        return totalTime / count;
    }
}