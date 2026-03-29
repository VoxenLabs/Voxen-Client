using Avalonia.Controls;
using Avalonia.Input;
using System.Diagnostics;
using Voxen.Client.ViewModels;

namespace Voxen.Client.Views;

public partial class MainView : UserControl
{
    public MainView()
    {
        InitializeComponent();
    }

    private void OnDialogPanelReleased(object? sender, PointerReleasedEventArgs e)
    {
        if (e.Source == sender) {
            (DataContext as MainViewModel)?.CloseCurrentDialog();
        }
    }
}
