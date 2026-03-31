using Voxen.Client.Domain.ServerDefinitions.Models;
using Voxen.Client.Domain.ServerDefinitions.RepositoryInterfaces;

namespace Voxen.Client.Domain.ServerDefinitions.UseCases;

public class StoreServerUseCase(IServerRepository serverRepository)
{
    private readonly IServerRepository serverRepository = serverRepository;

    public void Invoke(Server server)
    {
        if (!IsServerAlreadyStored(server))
        {
            serverRepository.StoreServer(server);
        }
    }

    private bool IsServerAlreadyStored(Server server)
    {
        return serverRepository.GetStoredServers().Contains(server);
    }
}
