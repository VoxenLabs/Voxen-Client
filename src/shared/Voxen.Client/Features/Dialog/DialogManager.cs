using Voxen.Client.ViewModels;

namespace Voxen.Client.Features.Dialog
{
    public class DialogManager
    {
        public static DialogManager _shared = new();

        public static DialogManager Shared
        {
            get { return _shared; }
        }

        private IDialogHandler? _currentHandler;

        public void PresentDialog(ViewModelBase dialogViewModel)
        {
            _currentHandler?.PresentDialog(dialogViewModel);
        }

        public void CloseCurrentDialog()
        {
            _currentHandler?.CloseCurrentDialog();
        }

        public void SetCurrentHandler(IDialogHandler dialogHandler)
        {
            _currentHandler = dialogHandler;
        }
    }
}
