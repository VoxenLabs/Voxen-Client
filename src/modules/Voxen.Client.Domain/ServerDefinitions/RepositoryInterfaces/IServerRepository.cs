using Voxen.Client.Domain.ServerDefinitions.Models;

namespace Voxen.Client.Domain.ServerDefinitions.RepositoryInterfaces;

public interface IServerRepository
{
    public List<Server> GetStoredServers();
    public void StoreServer(Server server);
    public void RemoveStoredServer(Server server);
}
