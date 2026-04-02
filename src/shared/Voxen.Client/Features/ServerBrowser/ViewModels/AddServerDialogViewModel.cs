using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using Voxen.Client.Domain.ServerDefinitions.Models;
using Voxen.Client.Domain.ServerDefinitions.UseCases;
using Voxen.Client.Features.Dialog;
using Voxen.Client.ViewModels;

namespace Voxen.Client.Features.ServerBrowser.ViewModels;

public partial class AddServerDialogViewModel(Action<Server> onServerAdded, StoreServerUseCase storeServer) : ViewModelBase
{
    [ObservableProperty]
    private string hostname = "";
    [ObservableProperty]
    private string port = "";

    private readonly Action<Server> onServerAdded = onServerAdded;
    private readonly StoreServerUseCase storeServer = storeServer;

    [RelayCommand]
    private void AddServer()
    {
        if (ValidateInput())
        {
            Server server = new(Hostname.Trim(), Port.Trim(), new ServerInfo("Test", null), null);
            storeServer.Invoke(server);
            onServerAdded(server);
            DialogManager.Shared.CloseCurrentDialog();
        }
    }

    private bool ValidateInput()
    {
        if (Hostname.Trim().Length > 0 && Port.Trim().Length > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
