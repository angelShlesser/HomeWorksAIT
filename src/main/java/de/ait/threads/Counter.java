package de.ait.threads;

public class Counter {

    /**
     * **Задача:**
     * 1. Создать класс `Counter` с полем `int count`.
     * 2. Создать класс `CounterThread`, расширяющий `Thread`,
     * который в методе `run()` увеличивает значение счетчика `Counter` на 1 каждые 100 миллисекунд.
     * 3. В главном классе (`Main`) создать объект `Counter`
     * и два объекта `CounterThread`, запустить оба потока.
     * 4. После завершения работы потоков вывести итоговое значение счетчика.
     */

    private int count = 0;

    public synchronized void increment(){
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}
