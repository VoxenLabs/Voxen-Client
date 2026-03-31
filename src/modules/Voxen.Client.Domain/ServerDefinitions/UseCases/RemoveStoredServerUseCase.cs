using Voxen.Client.Domain.ServerDefinitions.Models;
using Voxen.Client.Domain.ServerDefinitions.RepositoryInterfaces;

namespace Voxen.Client.Domain.ServerDefinitions.UseCases;

public class RemoveStoredServerUseCase(IServerRepository serverRepository)
{
    private readonly IServerRepository serverRepository = serverRepository;

    public void Invoke(Server server)
    {
        serverRepository.RemoveStoredServer(server);
    }
}
