using Voxen.Client.Domain.ServerDefinitions.Models;
using Voxen.Client.Domain.ServerDefinitions.RepositoryInterfaces;

namespace Voxen.Client.Domain.ServerDefinitions.UseCases
{
    public class GetStoredServersUseCase(IServerRepository serverRepository)
    {
        private readonly IServerRepository serverRepository = serverRepository;

        public List<Server> Invoke()
        {
            return serverRepository.GetStoredServers();
        }
    }
}
