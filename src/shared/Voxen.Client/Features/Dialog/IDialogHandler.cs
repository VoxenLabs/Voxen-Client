using System;
using System.Collections.Generic;
using System.Text;
using Voxen.Client.ViewModels;

namespace Voxen.Client.Features.Dialog
{
    public interface IDialogHandler
    {
        void PresentDialog(ViewModelBase dialogViewModel);
        void CloseCurrentDialog();
    }
}
