using SecureLocalStorage;
using Voxen.Client.Domain.ServerDefinitions.Models;
using Voxen.Client.Domain.ServerDefinitions.RepositoryInterfaces;

namespace Voxen.Client.Data.ServerDefinitions.Repositories;

public class ServerRepository : IServerRepository
{
    private const string SERVER_KEY = "servers";

    private readonly SecureLocalStorage.SecureLocalStorage storage;

    public ServerRepository()
    {
        // TODO: Make an extra abstraction for storage, inject SecureLocalStorage
        var config = new DefaultLocalStorageConfig();
        storage = new SecureLocalStorage.SecureLocalStorage(config);
    }

    public List<Server> GetStoredServers()
    {
        return storage.Get<List<Server>?>(SERVER_KEY) ?? [];
    }

    public void RemoveStoredServer(Server server)
    {
        var servers = GetStoredServers();
        servers.Remove(server);

        storage.Set(SERVER_KEY, servers);
    }

    public void StoreServer(Server server)
    {
        var servers = GetStoredServers();
        servers.Add(server);

        storage.Set(SERVER_KEY, servers);
    }
}
