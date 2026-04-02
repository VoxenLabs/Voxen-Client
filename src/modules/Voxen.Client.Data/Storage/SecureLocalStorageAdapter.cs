using SecureLocalStorage;

namespace Voxen.Client.Data.Storage;

public class SecureLocalStorageAdapter : IStorage<string>
{
    private readonly SecureLocalStorage.SecureLocalStorage storage;

    public SecureLocalStorageAdapter()
    {
        var config = new DefaultLocalStorageConfig();
        storage = new SecureLocalStorage.SecureLocalStorage(config);
    }

    /// <inheritdoc />
    public T? Get<T>(string key)
    {
        return storage.Get<T?>(key);
    }

    /// <inheritdoc />
    public void Set<T>(string key, T value)
    {
        storage.Set(key, value);
    }

    /// <inheritdoc />
    public void Remove(string key)
    {
        storage.Remove(key);
    }

    /// <inheritdoc />
    public void Clear()
    {
        storage.Clear();
    }
}
