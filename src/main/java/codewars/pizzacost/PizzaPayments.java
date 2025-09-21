package codewars.pizzacost;


public class PizzaPayments {
    public static double michaelPays(double cost) {
        double result = cost < 5 ? cost : cost > 5 && (cost / 3) < 10 ? cost - cost / 3 : cost - 10;
        return Math.round(result * 100) / 100.0;
    }

    public static void main(String[] args) {
        System.out.println(michaelPays(28.789));
    }
}


/*
Кейт и Майкл хотят купить пиццу и разделить её на двоих. В зависимости от цены пиццы, они разделят расходы:

Если пицца стоит меньше 5 евро, Майкл приглашает Кейт, и Майкл платит полную стоимость.
В противном случае Кейт вносит 1/3 от стоимости, но не более 10 евро (она нищая :-), а Майкл платит остальное.
Сколько заплатит Майкл? Рассчитайте сумму с точностью до двух десятых, если необходимо.*/

/* assertEquals(10, PizzaPayments.michaelPays(15), 0.0);
        assertEquals(4, PizzaPayments.michaelPays(4), 0.0);
        assertEquals(20, PizzaPayments.michaelPays(30), 0.0);
        assertEquals(70, PizzaPayments.michaelPays(80), 0.0);
        assertEquals(14.67, PizzaPayments.michaelPays(22), 0.0);
        assertEquals(3.95, PizzaPayments.michaelPays(5.9181), 0.0);
        assertEquals(19.19, PizzaPayments.michaelPays(28.789), 0.0);
        assertEquals(4.33, PizzaPayments.michaelPays(4.325), 0.0);       */