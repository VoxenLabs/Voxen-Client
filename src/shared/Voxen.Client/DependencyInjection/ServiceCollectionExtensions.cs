using Microsoft.Extensions.DependencyInjection;
using Voxen.Client.Data.ServerDefinitions.Repositories;
using Voxen.Client.Domain.ServerDefinitions.RepositoryInterfaces;
using Voxen.Client.Domain.ServerDefinitions.UseCases;
using Voxen.Client.Features.ServerBrowser.ViewModels;

namespace Voxen.Client.Extensions;

public static class ServiceCollectionExtensions
{
    public static void AddServerDependencies(this IServiceCollection collection)
    {
        // Repositories
        collection.AddSingleton<IServerRepository, ServerRepository>();

        // Use cases
        collection.AddTransient<GetStoredServersUseCase>();
        collection.AddTransient<RemoveStoredServerUseCase>();
        collection.AddTransient<StoreServerUseCase>();

        collection.AddTransient<ServerBrowserViewModel>();
    }
}
