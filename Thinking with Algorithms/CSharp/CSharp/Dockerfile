FROM mcr.microsoft.com/dotnet/aspnet:7.0 AS base
WORKDIR /app
EXPOSE 80
EXPOSE 443

FROM mcr.microsoft.com/dotnet/sdk:7.0 AS build
WORKDIR /src
COPY ["CSharp/CSharp.csproj", "CSharp/"]
RUN dotnet restore "CSharp/CSharp.csproj"
COPY . .
WORKDIR "/src/CSharp"
RUN dotnet build "CSharp.csproj" -c Release -o /app/build

FROM build AS publish
RUN dotnet publish "CSharp.csproj" -c Release -o /app/publish

FROM base AS final
WORKDIR /app
COPY --from=publish /app/publish .
ENTRYPOINT ["dotnet", "CSharp.dll"]
