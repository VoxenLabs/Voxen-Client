using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using System.Collections.ObjectModel;

namespace Voxen.Client.ViewModels;

public partial class ServerBrowserViewModel : ObservableObject
{
    [ObservableProperty]
    private ObservableCollection<string> servers = new();

    public ServerBrowserViewModel()
    {
        // Example: prepopulate servers if you want
        // Servers.Add("A");
        // Servers.Add("B");
    }

    [RelayCommand]
    private void AddServer()
    {
        // Here you would open a dialog to create a new server
        Servers.Add("New Server");
    }
}
