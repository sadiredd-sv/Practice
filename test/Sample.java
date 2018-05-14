import java.util.*;

class User implements Comparable<User>{
    String name;
    int balance;

    User(String name) {
        this.name = name;
        this.balance=0;
    }

    @Override
    public int compareTo(User user) {
        return this.balance - user.balance;
    }
}

class Expense {

    int money;
    User payer;
    List<User> paidForList;

    Expense(int money, User payer, List<User> paidForList) {
        this.money = money;
        this.payer=payer;
        this.paidForList = paidForList;
    }
}

class Sample {

    public static void calculateBalances(Expense expense) {

        int moneyPerPerson = expense.money/expense.paidForList.size();

        for(User user : expense.paidForList) {
            user.balance = user.balance - moneyPerPerson;
        }

        User payer = expense.payer;
        payer.balance+=expense.money;

    }

    /* Time complexity is O(nlogn) */
    public static void transactions(List<User> list) {

        int left = 0;
        int right = list.size()-1;

        while(left<=right) {
            if( list.get(left).balance<0 && list.get(right).balance>0 ) {
                if( Math.abs(list.get(left).balance) <=  Math.abs(list.get(right).balance) ) {
                    System.out.println(list.get(left).name+" paid "+ Math.abs(list.get(left).balance)+" to "+ list.get(right).name);
                    list.get(left).balance=0;
                    left++;
                }
                else if(Math.abs(list.get(left).balance) >  Math.abs(list.get(right).balance)){
                    System.out.println(list.get(left).name+" paid "+ Math.abs(list.get(right).balance)+" to "+list.get(right).name);
                    list.get(right).balance=0;
                    right--;
                }
            }
            else
                break;
        }

    }

    public static void main(String args[]) {

        User sarah = new User("Sarah");
        User alice = new User("Alice");
        User john = new User("John");
        User bob = new User("Bob");

        List<User> list = new ArrayList<User>();
        list.add(alice);
        list.add(john);
        list.add(bob);
        list.add(sarah);

        Expense expenseSarah = new Expense(400, sarah, list );


        List<User> list2 = new ArrayList<User>();
        list2.add(alice);
        list2.add(bob);
        Expense expenseJohn = new Expense(100, john, list2 );

        calculateBalances(expenseSarah);

        System.out.println(sarah.balance);
        System.out.println(alice.balance);
        System.out.println(john.balance);
        System.out.println(bob.balance);


        calculateBalances(expenseJohn);

        System.out.println("After second expense: ");
        System.out.println(sarah.balance);
        System.out.println(alice.balance);
        System.out.println(john.balance);
        System.out.println(bob.balance);


        Collections.sort(list);
        System.out.println("\n After Sorting: ");
        for (User user : list)
            System.out.println(user.name +" has balance of "+user.balance);


        System.out.println("\n Print Transactions");
        transactions(list);

    }

}