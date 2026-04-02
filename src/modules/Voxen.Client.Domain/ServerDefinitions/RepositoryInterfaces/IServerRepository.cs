using Voxen.Client.Domain.ServerDefinitions.Models;

namespace Voxen.Client.Domain.ServerDefinitions.RepositoryInterfaces;

public interface IServerRepository
{
    /// <summary>
    /// Retrieves all stored <see cref="Server"/> instances.
    /// </summary>
    /// <returns>
    /// A list of stored <see cref="Server"/> objects, or an empty list if none are found.
    /// </returns>
    public List<Server> GetStoredServers();

    /// <summary>
    /// Stores a new <see cref="Server"/> instance.
    /// </summary>
    /// <param name="server">The server instance to store.</param>
    public void StoreServer(Server server);

    /// <summary>
    /// Removes a specific <see cref="Server"/> instance.
    /// </summary>
    /// <param name="server">The server instance to remove.</param>
    public void RemoveStoredServer(Server server);
}
