$base = Get-Item .

Get-ChildItem -Recurse -File | 
Select-Object `
    @{Name='Carpeta';Expression={ 
        $relativePath = (Resolve-Path $_.DirectoryName).Path.Replace($base.FullName, '').TrimStart('\')
        if ($relativePath -eq '') { '.' } else { $relativePath }
    }},
    @{Name='Archivo';Expression={$_.Name}} |
Format-Table -AutoSize Carpeta, Archivo
