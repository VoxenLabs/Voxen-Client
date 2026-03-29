namespace Voxen.Client.Domain.ServerDefinitions.Models
{
    public record Server(string Hostname, string Port, ServerInfo ServerInfo, string? JwtToken);
}
