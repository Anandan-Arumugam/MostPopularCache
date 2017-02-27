
public class CheckLRU {
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(5);
		cache.addToCache(10);
		cache.addToCache(20);
		cache.addToCache(30);
		cache.addToCache(40);
		cache.addToCache(50);
		cache.addToCache(60);
		cache.addToCache(70);
		cache.addToCache(70);
		cache.addToCache(70);
		cache.addToCache(30);
		
		cache.printCacheElements();
	}
}
