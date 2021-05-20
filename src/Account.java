import java.util.Objects;

interface OnlineAccount {
    int basePrice = 120;
    int regularMoviePrice = 45;
    int exclusiveMoviePrice = 80;
}

class Account implements OnlineAccount, Comparable<Account> {

    int noOfRegularMovies, noOfExclusiveMovies;
    String ownerName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return noOfRegularMovies == account.noOfRegularMovies && noOfExclusiveMovies == account.noOfExclusiveMovies && Objects.equals(ownerName, account.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noOfRegularMovies, noOfExclusiveMovies, ownerName);
    }

    // 1) Add a parameterized constructor that initializes the attributes noOfRegularMovies and noOfExclusiveMovies.
    public Account(String ownerName, int noOfRegularMovies, int noOfExclusiveMovies) {
        this.noOfRegularMovies = noOfRegularMovies;
        this.noOfExclusiveMovies = noOfExclusiveMovies;
        this.ownerName = ownerName;
    }

    // 2. This method returns the monthly cost for the account.
    public int monthlyCost() {
        return basePrice +
                noOfRegularMovies * regularMoviePrice +
                noOfExclusiveMovies * exclusiveMoviePrice;
    }

    // 3. Override the compareTo method of the Comparable interface such that two accounts can be compared based on their monthly cost.
    @Override
    public int compareTo(Account o) {
        return Integer.compare(monthlyCost(), o.monthlyCost());
    }

    // 4. Returns "Owner is [ownerName] and monthly cost is [monthlyCost] USD."
    public String toString() {
        return "Owner is " + ownerName + " and monthly cost is " + monthlyCost() + " USD.";

    }
}