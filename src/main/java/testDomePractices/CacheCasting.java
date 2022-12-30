package testDomePractices;
/*
* A company is designing the class hierarchy for various cache implementations:
public class Cache {}
public class DiskCache extends Cache {}
public class MemoryCache extends Cache {}
public class OptimizedDiskCache extends DiskCache {}

Select all the answers that will result in a runtime exception.
* */
public class CacheCasting {
    public static void main(String[] args) {

        System.out.println("castOptimizedDiskCacheToCache:"  + castOptimizedDiskCacheToCache());
        System.out.println("castMemoryCacheToCacheToDiskCache:"  + castMemoryCacheToCacheToDiskCache());
        System.out.println("castDiskCacheToOptimizedDiskCache:"  + castDiskCacheToOptimizedDiskCache());
        System.out.println("castOptimizedDiskCacheToDiskCache:"  + castOptimizedDiskCacheToDiskCache());
        System.out.println("castCacheToMemoryCache:"  + castCacheToMemoryCache());
        System.out.println("castOptimizedDiskCacheToCacheToDiskCache:"  + castOptimizedDiskCacheToCacheToDiskCache());
    }

    private static boolean castOptimizedDiskCacheToCache() {
        try {
            OptimizedDiskCache optimizedDiskCache = new OptimizedDiskCache();
            Cache cache = (Cache) optimizedDiskCache;
        } catch (RuntimeException e) {
            return false;
        }
        return true;
    }

    private static boolean castMemoryCacheToCacheToDiskCache() {
        try {
            MemoryCache memoryCache = new MemoryCache();
            Cache cache = (Cache) memoryCache;
            DiskCache diskCache = (DiskCache) cache;
        } catch (RuntimeException e) {
            return false;
        }
        return true;
    }

    private static boolean castDiskCacheToOptimizedDiskCache() {
        try {
            DiskCache diskCache = new DiskCache();
            OptimizedDiskCache optimizedDiskCache = (OptimizedDiskCache) diskCache;
        } catch (RuntimeException e) {
            return false;
        }
        return true;
    }

    private static boolean castOptimizedDiskCacheToDiskCache() {
        try {
            OptimizedDiskCache optimizedDiskCache = new OptimizedDiskCache();
            DiskCache diskCache = (DiskCache) optimizedDiskCache;
        } catch (RuntimeException e) {
            return false;
        }
        return true;
    }

    private static boolean castCacheToMemoryCache() {
        try {
            Cache cache = new Cache();
            MemoryCache memoryCache = (MemoryCache) cache;
        } catch (RuntimeException e) {
            return false;
        }
        return true;
    }

    private static boolean castOptimizedDiskCacheToCacheToDiskCache() {
        try {
            OptimizedDiskCache optimizedDiskCache = new OptimizedDiskCache();
            Cache cache = (Cache) optimizedDiskCache;
            DiskCache diskCache = (DiskCache) cache;
        } catch (RuntimeException e) {
            return false;
        }
        return true;
    }
}

class Cache {
}

class DiskCache extends Cache {
}

class MemoryCache extends Cache {
}

class OptimizedDiskCache extends DiskCache {
}