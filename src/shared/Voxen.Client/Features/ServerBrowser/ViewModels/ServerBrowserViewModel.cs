using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using Microsoft.Extensions.DependencyInjection;
using System.Collections.ObjectModel;
using Voxen.Client.Domain.ServerDefinitions.Models;
using Voxen.Client.Domain.ServerDefinitions.UseCases;
using Voxen.Client.Features.Dialog;
using Voxen.Client.ViewModels;

namespace Voxen.Client.Features.ServerBrowser.ViewModels;

public partial class ServerBrowserViewModel(GetStoredServersUseCase getStoredServers, RemoveStoredServerUseCase removeStoredServer) : ViewModelBase
{
    [ObservableProperty]
    private ObservableCollection<Server> servers = new(getStoredServers.Invoke());

    private readonly RemoveStoredServerUseCase removeStoredServer = removeStoredServer;

    [RelayCommand]
    private void AddServer()
    {
        var onServerAdded = (Server server) =>
        {
            Servers.Add(server);
        };
        var addServerDialogViewModel = ActivatorUtilities.CreateInstance<AddServerDialogViewModel>(App.Current.Services, onServerAdded);
        DialogManager.Shared.PresentDialog(addServerDialogViewModel);
    }

    [RelayCommand]
    private void RemoveServer(Server server)
    {
        removeStoredServer.Invoke(server);
        Servers.Remove(server);
    }
}
