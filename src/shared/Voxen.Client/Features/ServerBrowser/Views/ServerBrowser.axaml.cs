using Avalonia.Controls;
using Microsoft.Extensions.DependencyInjection;
using Voxen.Client.Features.ServerBrowser.ViewModels;

namespace Voxen.Client.Features.ServerBrowser.Views;

public partial class ServerBrowser : UserControl
{
    public ServerBrowser()
    {
        InitializeComponent();
        DataContext = App.Current.Services.GetRequiredService<ServerBrowserViewModel>();
    }
}
