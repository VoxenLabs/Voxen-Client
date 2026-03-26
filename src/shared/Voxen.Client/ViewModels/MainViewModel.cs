using CommunityToolkit.Mvvm.ComponentModel;

namespace Voxen.Client.ViewModels;

public partial class MainViewModel : ViewModelBase
{
    [ObservableProperty]
    private string _greeting = "Welcome to Avalonia!";

    public ServerBrowserViewModel ServerBrowserVM { get; } = new();
}
