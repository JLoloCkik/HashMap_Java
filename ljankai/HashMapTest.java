package ljankai;

import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {

    @org.junit.jupiter.api.Test
    void add() {
        HashMap<Integer, Integer> map = new HashMap<>();

        assertTrue(map.add(1, 100), "Az 1-es kulcshoz tartozó értéket sikeresen hozzáadtuk.");
        assertTrue(map.add(2, 200), "A 2-es kulcshoz tartozó értéket sikeresen hozzáadtuk.");

        assertFalse(map.add(1, 150), "Nem sikerült újra hozzáadni az 1-es kulcsot, mert már létezik.");
    }

    @org.junit.jupiter.api.Test
    void remove() {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.add(1, 100);
        map.add(2, 200);

        assertEquals(100, map.remove(1), "Az 1-es kulcshoz tartozó értéket sikeresen eltávolítottuk.");
        assertNull(map.get(1), "Az 1-es kulcs már nem található a map-ben.");

        assertNull(map.remove(3), "A nem létező kulcs eltávolítása null-t kell visszaadjon.");
    }

    @org.junit.jupiter.api.Test
    void get() {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.add(1, 100);
        map.add(2, 200);

        assertEquals(100, map.get(1), "Az 1-es kulcshoz tartozó érték visszaadása helyes.");
        assertEquals(200, map.get(2), "A 2-es kulcshoz tartozó érték visszaadása helyes.");

        assertNull(map.get(3), "A nem létező kulcs értéke null.");
    }
}