using Voxen.Client.Data.Storage;
using Voxen.Client.Domain.ServerDefinitions.Models;
using Voxen.Client.Domain.ServerDefinitions.RepositoryInterfaces;

namespace Voxen.Client.Data.ServerDefinitions.Repositories;

public class ServerRepository : IServerRepository
{
    private const string SERVER_KEY = "servers";

    private readonly IStorage<string> storage;

    public ServerRepository(IStorage<string> storage)
    {
        this.storage = storage;
    }

    /// <inheritdoc cref="IServerRepository"/>
    public List<Server> GetStoredServers()
    {
        return storage.Get<List<Server>?>(SERVER_KEY) ?? [];
    }

    /// <inheritdoc cref="IServerRepository"/>
    public void RemoveStoredServer(Server server)
    {
        var servers = GetStoredServers();
        servers.Remove(server);

        storage.Set(SERVER_KEY, servers);
    }

    /// <inheritdoc cref="IServerRepository"/>
    public void StoreServer(Server server)
    {
        var servers = GetStoredServers();
        servers.Add(server);

        storage.Set(SERVER_KEY, servers);
    }
}
