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
        // Optional: prepopulate
        // Servers.Add("A");
        // Servers.Add("B");
    }

    [RelayCommand]
    private void AddServer()
    {
        // Just for demo: add a new server with a number
        int count = Servers.Count + 1;
        Servers.Add($"Server {count}");
    }
}
