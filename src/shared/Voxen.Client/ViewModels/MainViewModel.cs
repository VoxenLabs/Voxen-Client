using CommunityToolkit.Mvvm.ComponentModel;
using Voxen.Client.ServerBrowser.ViewModels;


namespace Voxen.Client.ViewModels;

public partial class MainViewModel : ViewModelBase
{
    [ObservableProperty]
    private string _greeting = "Welcome to Avalonia!";

    public ServerBrowserViewModel ServerBrowserVM { get; } = new();
}
