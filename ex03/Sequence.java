package t_11_holdingYourObjects.ex03;

import java.util.ArrayList;
import java.util.List;

interface Selector {
    boolean end();

    Object current();

    void next();
}

public class Sequence {
    private List<Object> items;

    public Sequence(int size)
    {
        items = new ArrayList<Object>(size);
    }

    public void add(Object x)
    {
        items.add(x);
    }

    private class SequenceSelector implements Selector {
        private final int DEFAULT_SIZE = 0;

        private int i = 0;

        public boolean end()
        {
            return i == items.size();
        }

        public Object current()
        {
            return items.get(i);
        }

        public void next()
        {
            i++;
        }

        public Sequence getSequence()
        {
            return new Sequence(DEFAULT_SIZE);
        }

        public Sequence getSequence(int size)
        {
            return new Sequence(size);
        }

    }

    public Selector selector()
    {
        return new SequenceSelector();
    }

    public static void main(String[] args)
    {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        Selector selector = sequence.selector();
        while (!selector.end())
        {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}
