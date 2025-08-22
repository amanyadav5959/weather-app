package com.cfs.weather_app.dto;




    public class Root{
        public Location getLocation() {
            return location;
        }

        public Root() {
        }

        public Root(Location location, Current current) {
            this.location = location;
            this.current = current;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public Current getCurrent() {
            return current;
        }

        public void setCurrent(Current current) {
            this.current = current;
        }

        public Location location;
        public Current current;
    }


