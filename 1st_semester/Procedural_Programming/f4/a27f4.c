/*  Αρχείο: a27f4.c
    Φοιτητής: Ευστάθιος Ιωσηφίδης
    ΑΜ: iis21027

    Στις περιπτώσεις κωδικών που αποτελούνται από ένα μεγάλο αριθμό ψηφίων (πχ. λογαριασμών τραπεζών, κωδικών πληρωμής κλπ)
    για την ασφάλεια των συναλλαγών θα πρέπει να υπάρχει ένας εύκολος τρόπος εξασφάλισης ότι ο χρήστης δεν πληκτρολογεί λάθος τα ψηφία.
    Ο τρόπος είναι να προστίθενται στους κωδικούς ψηφία ελέγχου. Ένας απλός τρόπος για το παραπάνω είναι να προστίθενται 2 ψηφία ελέγχου
    στο τέλος του κωδικού δημιουργώντας έτσι το τελικό κωδικό. Για παράδειγμα:
	Αρχικός κωδικός (Ν)			Ψηφία Ελέγχου			Τελικός Κωδικός (ΕΝ)
		12558				     60				            1255860
		55257				     03				            5525703

    Τα ψηφία ελέγχου ενός αρχικού κωδικού Ν (long) δίνονται από το τύπο:
    	Ψηφία ελέγχου = (98 - (N*100) % 97) % 97    (1)

    Ο έλεγχος εγκυρότητας ενός τελικού κωδικού ΕΝ υπολογίζεται εύκολα ελέγχοντας αν η πράξη ΕΝ % 97 έχει ως αποτέλεσμα 1,
    δηλαδή δεδομένου ενός τελικού κωδικού EN αυτός είναι έγκυρος αν το ακέραιο υπόλοιπο του με τον αριθμό 97 είναι ένα.

    Να υλοποιήσετε:
    (α) Μια συνάρτηση encode η οποία δέχεται ένα αρχικό κωδικό (long) και επιστρέφει τον αντίστοιχο τελικό κωδικό (long).
    Αναφέρεται και πάλι ότι ο τελικός κωδικός προκύπτει από την προσθήκη στο τέλος ενός αρχικού κωδικού των ψηφίων ελέγχου,
    τα οποία δίνονται από το τύπο (1).
    (β) μια συνάρτηση check η οποία δέχεται ένα τελικό κωδικό και επιστρέφει TRUE αν είναι έγκυρος και FALSE σε αντίθετη περίπτωση.
    Αναφέρεται και πάλι ότι ο έλεγχος γίνεται εξετάζοντας αν το ακέραιο υπόλοιπο του τελικού κωδικού με το 97 είναι ίσο με 1.
    (γ) ένα πρόγραμμα το οποίο δέχεται από τον χρήστη δύο όρια αρχικών κωδικών (long) και εμφανίζει για κάθε κωδικό ανάμεσα σε αυτά
    τα δύο όρια τον αρχικό κωδικό, τον τελικό κωδικό και αν είναι έγκυρος ή όχι, σύμφωνα με τα παραδείγματα που ακολουθούν. Η εμφάνιση των
    μηνυμάτων θα γίνεται μέσω του κυρίως προγράμματος (συνάρτηση main(), δηλαδή η εντολή εμφάνισης των μηνυμάτων (printf) θα είναι στην main()).
    Υποθέστε ότι ο χρήστης δίνει πάντα όρια μεγαλύτερα του 0 και ότι το κάτω όριο (lower limit) θα είναι πάντα μικρότερο ή ίσο με το το άνω όριο
    (upper limit)). Δεν απαιτείται έλεγχος.
    Σημείωση: Αν το πρόγραμμά σας είναι σωστό, τότε όλοι οι τελικοί κωδικοί που θα εμφανίζεται θα είναι έγκυροι.
    */

#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

long encode(long code);
bool check(long encode);

int main()
{
    long up,lower,i;
    printf("Lower limit: ");
    scanf("%ld",&lower);
//    lower=GetLong();
    printf("Upper Limit: ");
    scanf("%ld",&up);
//    up=GetLong();
    for (i=lower ; i<=up ; i++)
    {
    	printf("Code: %ld Encoding %ld isValid: %s\n",i,encode(i),(check(encode(i))) ? "yes" : "no" );
    }

    return 0;

}

long encode(long code)
{
    long n, temp;
    n = (98 - (code*100) % 97) % 97;
    temp = n;
    while (n!=0)
    {
    code *= 10;
    n /= 10;
    }
    return code + temp;

}

bool check(long ncode)
{
    return (encode(ncode)%97==1) ? TRUE : FALSE;
}
