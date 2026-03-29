using CommunityToolkit.Mvvm.ComponentModel;
using Voxen.Client.Features.Dialog;
using Voxen.Client.Features.ServerBrowser.ViewModels;


namespace Voxen.Client.ViewModels;

public partial class MainViewModel : ViewModelBase, IDialogHandler
{
    [ObservableProperty]
    private ViewModelBase? currentDialog;

    public MainViewModel()
    {
        DialogManager.Shared.SetCurrentHandler(this);
    }

    public void PresentDialog(ViewModelBase dialogViewModel)
    {
        CurrentDialog = dialogViewModel;
    }

    public void CloseCurrentDialog()
    {
        CurrentDialog = null;
    }
}
