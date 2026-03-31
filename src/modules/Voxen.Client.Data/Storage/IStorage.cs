namespace Voxen.Client.Data.Storage;

/// <summary>
/// Defines a generic storage mechanism for storing and retrieving values by key.
/// </summary>
/// <typeparam name="KeyType">The type of the key used to identify stored values.</typeparam>
public interface IStorage<in KeyType>
{
    /// <summary>
    /// Retrieves a value of type <typeparamref name="T"/> associated with the specified key.
    /// </summary>
    /// <typeparam name="T">The expected type of the stored value.</typeparam>
    /// <param name="key">The key that identifies the value.</param>
    /// <returns>
    /// The value associated with the specified key, cast to type <typeparamref name="T"/>.
    /// </returns>
    T? Get<T>(KeyType key);

    /// <summary>
    /// Stores a value of type <typeparamref name="T"/> associated with the specified key.
    /// </summary>
    /// <typeparam name="T">The type of the value to store.</typeparam>
    /// <param name="key">The key that identifies the value.</param>
    /// <param name="value">The value to store.</param>
    void Set<T>(KeyType key, T value);

    /// <summary>
    /// Removes the value associated with the specified key.
    /// </summary>
    /// <param name="key">The key identifying the value to remove.</param>
    void Remove(KeyType key);

    /// <summary>
    /// Removes all values from the storage.
    /// </summary>
    void Clear();
}
