package objects.vietjet;

public class Passengers {
    int adults = 1;
    int children = 0;
    int infants = 0;

    private Passengers() {
    }

    public int getAdults() {
        return adults;
    }

    public int getChildren() {
        return children;
    }

    public int getInfants() {
        return infants;
    }

    public Passengers(int adults, int children, int infants) {
        this.adults = adults;
        this.children = children;
        this.infants = infants;
    }

    public static class Builder {
        private int adults = 1;
        private int children = 0;
        private int infants = 0;

        public Builder setAdults(int adults) {
            this.adults = adults;
            return this;
        }

        public Builder setChildren(int children) {
            this.children = children;
            return this;
        }

        public Builder setInfants(int infants) {
            this.infants = infants;
            return this;
        }

        public Passengers build() {
            return new Passengers(adults, children, infants);
        }
    }
}
